const productionUrl = 'http://localhost:80';
const developmentUrl = 'http://127.0.0.1:4523/mock/623670';

const request = axios.create({
  // baseURL: developmentUrl,
  baseURL: productionUrl,
  timeout: 1000,
});

request.defaults.headers.post['content-type'] = 'application/x-www-form-urlencoded';
