import CryptoJS from 'crypto-js';

export default function hashString (inputString) {
    return CryptoJS.SHA256(inputString).toString(CryptoJS.enc.Hex);
};  