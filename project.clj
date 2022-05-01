(defproject getclojure "2.0.0"
  :description "GetClojure"
  :url "http://getclojure.org"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.babashka/sci "0.3.5"]
                 [cheshire "5.10.2"]
                 [ring/ring-jetty-adapter "1.9.5"]
                 [ring/ring-defaults "0.3.3"]
                 [compojure "1.6.2"]
                 [hiccup "1.0.5"]
                 [com.github.seancorfield/next.jdbc "1.2.780"]
                 [org.postgresql/postgresql "42.3.4"]
                 [com.outpace/config "0.13.5"]
                 [com.algolia/algoliasearch-core "3.16.5"]
                 [com.algolia/algoliasearch-java-net "3.16.5"]
                 [enlive "1.1.6"]
                 [com.taoensso/timbre "5.2.1"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler getclojure.server/app
         :port 8080}
  :profiles {:dev {:dependencies [[ring-mock "0.1.5"]
                                  [ring/ring-devel "1.9.5"]
                                  [pjstadig/humane-test-output "0.11.0"]]
                   :injections [(require 'pjstadig.humane-test-output)
                                (pjstadig.humane-test-output/activate!)]
                   :plugins [[com.jakemccrary/lein-test-refresh "0.25.0"]]}
             :test {:resource-paths ["test-resources"] }}
  :min-lein-version "2.0.0")
