const prod = process.env.NODE_ENV === 'production';

export default {
  apiUrl: '/api',
  redirectUrl: prod ? '/ui/token' : 'http://localhost:3000/token'
};