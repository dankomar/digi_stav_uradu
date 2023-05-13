# Use a PostgreSQL base image
FROM postgres:latest

# Set environment variables
ENV POSTGIS_MAJOR 3
ENV POSTGIS_VERSION 3.1.4+dfsg-1.pgdg100+1

# Install PostGIS extension
RUN apt-get update && apt-get install -y --no-install-recommends \
    postgresql-$PG_MAJOR-postgis-$POSTGIS_MAJOR=$POSTGIS_VERSION \
    postgresql-$PG_MAJOR-postgis-$POSTGIS_MAJOR-scripts=$POSTGIS_VERSION \
    && rm -rf /var/lib/apt/lists/*

# Run additional setup scripts
COPY ./initdb-postgis.sh /docker-entrypoint-initdb.d/
RUN chmod +x /docker-entrypoint-initdb.d/initdb-postgis.sh

# Set the default command to run when starting the container
CMD ["postgres"]