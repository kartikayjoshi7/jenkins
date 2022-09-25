#!/bin/bash

ASG=$1

aws autoscaling start-instance-refresh --auto-scaling-group-name ${ASG}
