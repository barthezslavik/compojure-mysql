(ns compojure-mysql.routes.home
  (:require [compojure.core :refer :all]
            [korma.core :as k]
            [ring.middleware.json :as j]
            [cheshire.core :refer :all]
            [compojure-mysql.views.layout :as layout]))


(k/defentity document
  (k/table "documents"))

(defn home []
  (generate-string (k/select document)))

(defroutes home-routes
  (GET "/" [] (home)))
