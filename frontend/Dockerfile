FROM node:21-alpine

LABEL org.opencontainers.image.source=https://github.com/DenisionSoft/life-quality-index

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

EXPOSE 8081

CMD ["npm", "run", "serve"]