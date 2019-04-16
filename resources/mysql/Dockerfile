FROM mysql:5.7

ENV MYSQL_ROOT_PASSWORD secret
ENV MYSQL_USER matera
ENV MYSQL_PASSWORD matera
ENV MYSQL_DATABASE employees

COPY ./install.sql /docker-entrypoint-initdb.d/

CMD ["--explicit_defaults_for_timestamp=1"]