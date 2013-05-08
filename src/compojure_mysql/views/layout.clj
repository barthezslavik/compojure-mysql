(ns compojure-mysql.views.layout
  (:require [hiccup.def :refer [defhtml]]
            [hiccup.page :refer [include-css]]))

(defhtml common [& body]
  [:head
   [:title "Welcome to compojure-mysql"]
   (include-css "/css/screen.css")]
  [:body body])
