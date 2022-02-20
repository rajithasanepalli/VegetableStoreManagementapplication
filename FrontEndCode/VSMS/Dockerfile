### STAGE 1: Build ###
FROM node:10.16.3 AS node
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --no-cache


### STAGE 2: Run ###
FROM nginx:alpine
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=node /app/dist/darma /usr/share/nginx/html