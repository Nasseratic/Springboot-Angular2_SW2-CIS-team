/**
 * Created by LENOVO on 17/04/10.
 */
module.exports = {
navigateFallback: '/index.html',
  stripPrefix: 'dist',
  staticFileGlobs: [
    'dist/index.html',
    'dist/**.js',
    'dist/**.css',
    'dist/images/icons/**.png',
    'dist/**.webapp'
  ],
  runtimeCaching: [{
    "urlPattern": ":8080/*",
    "handler": "fastest"
  }]  
};
