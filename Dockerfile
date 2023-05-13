# Use the official PostgreSQL image as the base image
FROM postgres:latest

# Install PostGIS extension
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
        postgresql-13-postgis-3 && \
    rm -rf /var/lib/apt/lists/*

# Set environment variables for PostgreSQL
ENV POSTGRES_USER=admin
ENV POSTGRES_PASSWORD=dsuheslo
ENV POSTGRES_DB=postgis

# Set the default command to run when the container starts
CMD ["postgres"]
