const functions = require('firebase-functions');
const admin = require('firebase-admin');
admin.initializeApp();
const spawn = require('child-process-promise').spawn;
const path = require('path');
const os = require('os');
const fs = require('fs');

// Create and Deploy Your First Cloud Functions
// https://firebase.google.com/docs/functions/write-firebase-functions

exports.onFileChange = functions.storage.object().onFinalize(event => {
    console.log(event);
    return;
  
});
