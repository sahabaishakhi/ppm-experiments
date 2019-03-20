(ns ppm-1-threading.core
  (:use [clojure.string :only [join]]))

(def config {:small {:size 100 :filename "primitive-loop-small"}
             :normal {:size 255 :filename "primitive-loop"}
             :large {:size 1200 :filename "primitive-loop-large"}})

(defn line [width y-index]
  (->> (range width)
       (map #(vector % y-index (mod (* % y-index) width)))))

(defn screen [size]
  (->> (range size)
       (map #(line size %))
       flatten))

(defn image [size]
  (->> (screen size)
       (join " ")
       (str "P3\n" size " " size " " size "\n")))

(defn output [option]
  (->> (image (:size (config option)))
       (spit (str (:filename (config option)) ".ppm"))))

;; testing
(line 5 0)
(line 5 4)
(screen 5)
(image 5)

;; final
(output :large)
