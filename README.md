# trayio-task


## Description
Trayio-task is a web microservice used to manage a simplified version of tray.io's core workflow execution platform.


## Technical outline
The service is written using Play framework with Scala and H2 in memory database. Operations on the database are performed using Slick plugin. The application is built using sbt.


## Deployment
In order to deploy the service:

* Clone the project from gitHub `git clone https://github.com/HoneyB4dger/trayio-task.git`
* `cd trayio-task`
* `sbt run` - this will download the dependencies, check and compile the application
* You should see massage `(Server started, use Enter to stop and go back to the console...)`


## Usage
The service is running on `http://localhost:9000/`. If this is on your local machine, you can view that url in your internet browser. Here you can use the service thorugh web forms.

If you prefer to use command line, use the following REST endpoints:

##### GET /workflows
Returns a list of workflows.

##### GET /workflowExecutions
Returns a list of workflow executions.

##### POST /workflow
Adds a workflow to the service. Requires a number of steps in a workflow (int between 1-1024).
Format: `{"number_of_steps": n}`

##### POST /workflowExecution
Adds a workflow execution to the service. Requires a workflow id it is attached to.
Format: `{"workflow_id": n}`

##### POST /increment
Increment step index in workflow execution. Requires a workflow execution id.
Format: `{"workflow_execution_id": n}`

##### GET /checkIfFinished
Returns wheter or not a workflow execution has finished. Requires a workflow execution id.
Format: `{"workflow_execution_id": n}`


Example call:
`curl --header "Content-type: application/json" -X POST http://localhost:9000/workflow -d '{"number_of_steps": 4}'`


## Testing
You can test the service manually by either interacting with the web interface or performing REST calls. To test the service performing under a higher load, you can use a Python script (`autoTests.py`). It sends a random REST call at a given interval. To use `python autoTests.py -t <number_of_calls> -d <delay_between_calls>`



## Future improvements

Additional functionality to consider:

* Using in memory database H2. This can be replace for another DB (for example PostgreSQL) by modifying build.sbt and application.conf files. Check evolutions settings so that the database is not dropped each time the service starts.
* Default port that the application runs on is 9000. You can change this in Play, however a better way would be to set up a proxy server (Apache/Nginx).
* Interaction with the service takes place either via POST requests or http forms. This could be improved with [Swagger](https://github.com/swagger-api/swagger-codegen) which adds front end, documentation and testing functionality.
* Security needs to be reviewed - need to add claims authentication.
* Improve Play tests.
* Need to convert the service into production setting and package.
* Number of threads should be optimised for the machine the service is running on. 
* Workflow execution model would benefit from an additional field - "finished". This would help with the cleanup.
* Cleanup job could be improved - wait 1min after workflow execution has finished.
* Logging could be improved with an ELK stack.


