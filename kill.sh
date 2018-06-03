#!/bin/bash

lsof -ti:4000 | xargs kill
lsof -ti:8081 | xargs kill
lsof -ti:8082 | xargs kill
lsof -ti:8085 | xargs kill
lsof -ti:8761 | xargs kill
lsof -ti:8888 | xargs kill