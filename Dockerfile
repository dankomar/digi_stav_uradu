FROM ubuntu:latest
ARG TIME_ZONE=8

RUN apt-get update && apt-get install -y tzdata

# Set the timezone
ENV TZ=Europe

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

CMD ["date"]

RUN apt-get update && apt-get install -y wget lsb-release gnupg

RUN echo "deb http://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list
RUN wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | apt-key add -
RUN apt-get update
RUN apt-get -y install postgresql

CMD ["postgres"]
