#!/bin/bash

ASG=$1

aws autoscaling start-instance-refresh --auto-scaling-group-name ${ASG}
while true; do
  STATUS=$(aws autoscaling describe-instance-refresh --auto-scaling-group-name ${ASG} | jq .InstanceRefreshes[0].Status | sed -e 's/"//g')
  echo Instance Refresh Status={$STATUS}
  if [ "${STATUS}" == "InProgress"  ]; then

    sleep 30
    elif [ "${STATUS}" == "Successful" ]; then
        exit 0
        else
          exit 1
    fi
    done
