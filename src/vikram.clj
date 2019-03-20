(ns second-ppm.core)

(def head (str "P3\n" 255 " " 255 " " 255 "\n"))

(def matrix
  (str
   head (clojure.string/join
         "\n"
         (->> (range 0 255)
              (range (dec 255) -1 -1)
              (fn [i] (map (fn [j]
                       (let [x (mod i 255) y (mod j 255) z (mod (* i j) 255)]
                         (str x " " y " " z)))))
              (mapcat))
(def second-ppm matrix)

(spit "image.ppm" second-ppm)
