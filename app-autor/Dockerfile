FROM node

RUN mkdir -p /usr/src/app
# RUN npm install nodemon -g

WORKDIR /usr/src/app
COPY /app .
RUN npm install

EXPOSE 8080
EXPOSE 5858

CMD ["npm", "start"]