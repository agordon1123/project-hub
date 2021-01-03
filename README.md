# PROJECT HUB BACK-END API

### ENVIRONMENT

- To set up a local environment for development/testing:
    - ensure mysql is installed and a user with priveledges is provisioned
    - `mysql -u <username> -p < sql/01_CREATE.sql` and enter password when prompted
        - This command creates all tables needed to run the back-end API
    - create `application.properties` file and add the following keys:
        - ```
            app.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
            app.datasource.jdbc-url=jdbc:mysql://localhost:3306/project_hub_db?zeroDateTimeBehavior=convertToNull&autoReconnect=true&failOverReadOnly=false&maxReconnects=10&serverTimezone=UTC
            app.datasource.username=
            app.datasource.password=

            spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
            spring.datasource.url=jdbc:mysql://localhost:3306/project_hub_db?zeroDateTimeBehavior=convertToNull&autoReconnect=true&failOverReadOnly=false&maxReconnects=10&serverTimezone=UTC
            spring.datasource.username=
            spring.datasource.password=
        ```
    - start the project with the command `mvn spring-boot:run`


### TODO

- Set up auth layer for user login
