(defproject compojure-mysql "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.3"]
                 [mysql/mysql-connector-java "5.1.6"]
                 [korma "0.3.0-RC5"]
                 [cheshire "5.1.1"]
                 [ring/ring-json "0.2.0"]
                 [ring-server "0.2.8"]]
  :plugins [[lein-ring "0.8.5"]]
  :ring {:handler compojure-mysql.handler/war-handler
         :init compojure-mysql.handler/init
         :destroy compojure-mysql.handler/destroy}
  :profiles
  {:production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring-mock "0.1.3"] [ring/ring-devel "1.1.8"]]}})
