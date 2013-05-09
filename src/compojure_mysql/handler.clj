(ns compojure-mysql.handler
  (:require [compojure.core :refer [defroutes routes]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [hiccup.middleware :refer [wrap-base-url]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [korma.db :as db]
            [compojure-mysql.routes.home :refer [home-routes]]))

(defn init []
  (db/defdb db
    (db/mysql {:host "localhost"
               :port "3306"
               :db "clojure-learn"
               :user "root"
               :password ""}))
  (println "compojure-mysql is starting"))

(defn destroy []
  (println "compojure-mysql is shutting down"))

(defroutes app-routes
  (route/resources "/")
  (route/not-found "Not Found"))

(def app (handler/site (routes home-routes app-routes)))

(def war-handler
  (-> app
    (wrap-resource "public")
    (wrap-base-url)
    (wrap-file-info)))
