FROM postgres:latest

# Set the desired time zone (replace with your preferred time zone)
ENV TZ=Europe/Paris

# Update the system and install necessary packages
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    tzdata

# Set the time zone
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# Expose the default PostgreSQL port
EXPOSE 5432

# Start the PostgreSQL service
CMD ["postgres"]
