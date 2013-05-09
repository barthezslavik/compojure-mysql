(ns compojure-mysql.routes.home
  (:require [compojure.core :refer :all]
            [korma.core :as k]
            [korma.db :as db]
            [ring.middleware.json :as j]
            [cheshire.core :refer :all]
            [compojure-mysql.views.layout :as layout]))

(db/defdb db
  (db/mysql {:host "localhost"
             :port "3306"
             :db "clojure-learn"
             :user "root"
             :password ""}))

(k/defentity document
  (k/table "documents"))

(defn home []
  (generate-string (k/select document)))

(defroutes home-routes
  (GET "/" [] (home)))
