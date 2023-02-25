FROM node:16
WORKDIR /teachable-frontend
COPY package.json package-lock.json ./
RUN npm ci
COPY . .
RUN npm run build
ENV PORT 3000
EXPOSE 3000
EXPOSE 24678 
CMD ["node", "build"]