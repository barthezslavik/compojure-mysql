(ns compojure-mysql.routes.home
  (:require [compojure.core :refer :all]
            [korma.core :as k]
            [ring.middleware.json :as j]
            [cheshire.core :refer :all]
            [compojure-mysql.views.layout :as layout]))


(k/defentity document
  (k/table "documents"))

(defn all-documents []
  (generate-string (k/select document)))

(defn single-document [id]
  (generate-string
    (k/select document
      (k/where {:id id}))))

(defroutes home-routes
  (GET "/documents" [] (all-documents))
  (GET "/documents/:id" [id] (single-document id)))
