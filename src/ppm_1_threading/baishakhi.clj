(ns ppm-1-threading.baishakhi)

(def size 255)

(def head (str "P3\n" 255 " " 255 " " 255 "\n"))

(defn red []
  (map mod (range (* size size)) (repeat size)))

(defn green []
  (flatten (map repeat (repeat size) (range size))))

(defn blue []
  (map mod (map * (red) (green)) (repeat size)))

;testing
(red)
(type (red))
(count (red))

(green)
(type (green))
(count (green))

(blue)
(type (blue)) 
(count (blue))

(defn image-data-vals []
  (map str (red) (repeat " ") (green) (repeat " ") (blue)))

(image-data-vals)
(type (image-data-vals))
(count (image-data-vals))

(defn image-data []
  (clojure.string/join " " (image-data-vals)))

(image-data)

(defn ppm-content [] (str head "\n" (image-data)))

(ppm-content)

(spit "threadppmdemo.ppm" (ppm-content))
