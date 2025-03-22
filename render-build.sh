#!/bin/sh
export $(grep -v '^#' .env | xargs) && docker build -t healthsubscriptionapi-image -f ./Dockerfile . --build-arg DATABASE_URL --build-arg DATABASE_NAME