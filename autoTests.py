import optparse
import time
from random import randint
import requests

parser = optparse.OptionParser()

parser.add_option('-t', action="store", dest="t", help="number of tasks", default="1000")
parser.add_option('-d', action="store", dest="d", help="delay between calls in milliseconds", default="1000")
options, args = parser.parse_args()

print("Running %s calls with a delay of %sms" % (options.t, options.d))

# Create one of workflow and workflow execution
requests.post("http://localhost:9000/workflow", data={'number_of_steps': 5})
requests.post("http://localhost:9000/workflowExecution", data={'workflow_id': 1})
numberOfWorkflows = 1
numberOfWorkflowExecutions = 1


for i in range (0, int(options.t)):
    queryToRun = randint(0, 5)
    if queryToRun == 0: requests.get("http://localhost:9000/workflows")
    if queryToRun == 0: requests.get("http://localhost:9000/workflowExecutions")
    if queryToRun == 2:
        if randint(1, 10) == 10: # only create a workflow 10% of time so that there are not too many workflows
            s = randint(1, 10) # how many digits in the number of steps
            if s < 8: steps = randint(1, 9)
            if s == 8 or s == 9: steps = randint(10, 99)
            if s == 10: steps = randint(100, 1024)
            requests.post("http://localhost:9000/workflow", data={'number_of_steps': randint(1, 1024)})
            numberOfWorkflows += 1
    if queryToRun == 3:
        if randint(1, 10) < 4: # only create a workflow execution 30% of time so that there are not too many
            requests.post("http://localhost:9000/workflowExecution", data={'workflow_id': randint(1, numberOfWorkflows)})
            numberOfWorkflowExecutions += 1
    if queryToRun == 4: requests.post("http://localhost:9000/increment", data={'workflow_execution_id': randint(1, numberOfWorkflowExecutions)})
    if queryToRun == 5: requests.get("http://localhost:9000/checkIfFinished", data={'workflow_execution_id': randint(1, numberOfWorkflowExecutions)})
    time.sleep(int(options.d) / 1000.0)




