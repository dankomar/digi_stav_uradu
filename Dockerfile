# Use a PostgreSQL base image
FROM postgres:latest

# Set environment variables
ENV POSTGIS_MAJOR 3
ENV POSTGIS_VERSION 3.1

# Install PostGIS extension
RUN apt-get update \
    && apt-get install -y --no-install-recommends \
        postgresql-$PG_MAJOR-postgis-$POSTGIS_MAJOR \
    && rm -rf /var/lib/apt/lists/*

# Set the default command to run when starting the container
CMD ["postgres"]
