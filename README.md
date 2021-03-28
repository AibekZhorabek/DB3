# DB3

## Phase 3
#### Questions:
1. What are pharmacies in the patient/user’s city? 
2. What are the medicines these pharmacies have? 
3. Where can patients/users buy this medicine?
4. What about medicines’ prices in different pharmacies? 
5. What about medicine itself? (instruction, brief description, dosage, etc.) 
6. How do doctors rate this medicine? 
7. What do patients/users think about this medicine? 
8. What are clinics in the patient/user’s city? 
9. What information patient/user know about this clinic? (address, phone number, working hours and etc.)
10. What do doctors work in this clinic? 
11. How do patients rate this clinic? 
12. How do patients rate this doctor? 
13. What information patient/user know about this doctor? (education, experience, phone number and etc.)
14. How do patients make an appointment with a doctor?
15. How does the clinic/doctor/pharmacy join us?
16. How can users find medicines for a certain disease?
17. How can users find different types of clinics? (eye clinics, hospitals, etc.)
18. How can doctors find their reviews on certain medicine?
19. How can users find their comments on certain clinic/medicine/doctor?
20. Can they edit these comments?

#### Functionalities and Features of the project:
1. User chooses city, it lists all pharmacy registered in this city.
2. User can choose one pharmacy, and it lists all medicines which pharmacy have.
3. User chooses medicine, and it lists all pharmacies which this medicine in sale.
4. With pharmacies, it lists this medicine's price
5. In the medicine page, details of the medicine will be displayed.
6. Doctors can write pros,cons, and information about medicine and can rate it by 3 criteria (Efficiency,Price/Quality,Side Effects)
7. Users can leave a comment about medicine but cannot rate it
8. User chooses city, it lists all clinics registered in this city
9. In the clinic page, all information will be displayed
10. In the clinic page, user can see list of doctors who work in this clinic
11. Patients can leave a comment about clinic.
12. Patients can leave a comment about doctor.
13. In the doctor page, all necessary information will be displayed

#### Datasets
1. [HospInfo.csv](https://www.kaggle.com/cms/hospital-general-information)
2. [Medicine_description.xlsx](https://www.kaggle.com/saratchendra/medicine-recommendation?select=Medicine_description.xlsx)

## Phase4
Our database has 24 tables.
We have many-to-many connections, like between Doctor and Medical_Center, but because of database server cannot display this connection, we created new table Doctor_Medical_center. Also we have a lot of one-to-many connections between our tables, for example Appointment and User, User and Role, etc.

## Phase6
#### Connection to database
For the connection with database, we created class ConnectionPool, which takes DB parameters(driver,username,password,url,poolSize) and initializes the pool with 5 connection.
1. Set database parameters
```java
private void setDBParameters(){
        DBResourceManager dbResourceManager = DBResourceManager.getInstance();
        this.driverName = dbResourceManager.getValue(DBParameter.DB_DRIVER);
        this.url = dbResourceManager.getValue(DBParameter.DB_URL);
        this.user = dbResourceManager.getValue(DBParameter.DB_USER);
        this.password = dbResourceManager.getValue(DBParameter.DB_PASSWORD);
        try{
            this.poolSize = Integer.parseInt(dbResourceManager.getValue(DBParameter.DB_POOL_SIZE));
        }catch (NumberFormatException e){
            poolSize = 5;
        }
    }
```
2. Initialize pool
```java
private void initPoolData(){
        Connection connection;
        try{
            Class.forName(driverName);
            availableConnections = new ArrayBlockingQueue<>(poolSize);
            for(int i = 0; i < poolSize; i++){
                connection = DriverManager.getConnection(url,user,password);
                availableConnections.put(connection);
            }

        }catch (ClassNotFoundException e ){
            LOGGER.error("Can't find database driver class",e);
        }catch (SQLException e){
            LOGGER.error("SQLException in ConnectionPool",e);
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
    }
```
3. With method takeConnection(), our DAOs take connection and release it after they finished.
```java
public synchronized Connection takeConnection(){
        Connection connection = null;
        if(availableConnections.size() == 0){
            LOGGER.warn("All connections are used");
        }
        else {
            try {
                connection = availableConnections.take();
            } catch (InterruptedException e) {
                LOGGER.error("Error connecting to the data source", e);
            }
        }
        return connection;
    }

    public synchronized void releaseConnection(Connection connection){
        if(connection != null){
            try{
                availableConnections.put(connection);
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
        }
    }
```
