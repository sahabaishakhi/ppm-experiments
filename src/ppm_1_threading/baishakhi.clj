(ns ppm-1-threading.baishakhi)

(def size 255)

(def head (str "P3\n" 255 " " 255 " " 255 "\n"))

(defn red []
  (map mod (range (* size size)) (repeat size))
                                        ;(->> (repeat size) map mod (range (* size size)))  
  )

(defn green []
  (flatten (map repeat (repeat size) (range size)))
                                        ; (->> (range size) (map repeat (repeat size)) flatten)
  )

(defn blue []
  (map mod (map * (red) (green)) (repeat size)))

                                        ;testing
(red)
(count (red))
(green)
(count (green))
(blue)
(count (blue))

(defn image-data-vals []
  (map str (red) (repeat " ") (green) (repeat " ") (blue)))

(image-data-vals)
(type (list image-data-vals))
(count (image-data-vals))

(defn image-data []
  (clojure.string/join " " (list image-data-vals)))

(image-data)

(defn ppm-content [] (str head "\n" image-data))

(ppm-content)

(spit "threadppmdemo.ppm" ppm-content)

                                        ;(spit "threadppmdemo.ppm" (str head "\n" "0 0 255 255 0 0 0 255 0 255 0 0"))
