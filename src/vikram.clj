(ns second-ppm.core)

(def head (str "P3\n" 255 " " 255 " " 255 "\n"))

(def matrix
  (str
   head (clojure.string/join
         "\n"
         (->> (range 0 2)
              (range (dec 2) -1 -1)
              (fn [i] (map (fn [j]
                       (let [x (mod i 2) y (mod j 2) z (mod (* i j) 255)]
                         (str x " " y " " z)))))
              (mapcat))
(def second-ppm matrix)

(spit "image.ppm" second-ppm)
