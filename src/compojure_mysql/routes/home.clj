(ns compojure-mysql.routes.home
  (:require [compojure.core :refer :all]
            [korma.core :refer :all]
            [cheshire.core :refer :all]
            [compojure-mysql.views.layout :as layout]))


(defentity document
  (table "documents"))

(defn all-documents []
  (generate-string (select document)))

(defn single-document [id]
  (generate-string
    (first
      (select document
        (where {:id id})))))

(defroutes home-routes
  (GET "/documents" [] (all-documents))
  (GET "/documents/:id" [id] (single-document id)))
