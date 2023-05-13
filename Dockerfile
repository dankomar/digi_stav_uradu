FROM postgres:latest

# Update the system and install necessary packages
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    postgis

# Expose the default PostgreSQL port
EXPOSE 5432

# Start the PostgreSQL service
CMD ["postgres"]

RUN -u postgres psql -c "CREATE EXTENSION postgis; CREATE EXTENSION postgis_topology;" postgres
