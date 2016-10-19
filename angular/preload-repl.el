(require 'nodejs-repl-eval)
(dolist
		(x '("minErr.js" "Angular.js" "loader.js" "injector.js" "locale.js"
				 "AngularPublic.js" "apis.js"))
	(nodejs-repl-eval-buffer (get-buffer x)))

;; .load minErr.js
;; .load Angular.js
;; .load loader.js
;; .load auto/injector.js
;; .load ng/locale.js
;; .load AngularPublic.js
;; .load apis.js
