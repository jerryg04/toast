var Toast = function () {

};

Toast.prototype = {
    /**
     * Open the Android share dialog.
     */
	mostrar: function (message, win, fail) {
		cordova.exec(win, fail, 'toast', 'mostrar', [{mensaje:message.mensaje}]);
	}
		   
};

var toast = new Toast();

module.exports = toast;
