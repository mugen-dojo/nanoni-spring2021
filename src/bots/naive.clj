(ns bots.template
  (:require [clojure.string :as str]))

(defn output [msg] (println msg) (flush))
(defn debug [msg] (binding [*out* *err*] (println msg) (flush)))

(defn parse-stdin!
  "Helper function to reduce the redundant mess that is parsing Codingame’s data"
  [val-name]
  ; There are only two kinds of inputs:
  ;   a single integer or a list of integers
  ; as such, we just have to test if there is spaces in the provided input
  (let [input (read-line)]
    (debug (str/join " | " ["parse-stdin! " val-name input]))
    (cond
      (nil? (re-find #" " input)) (Integer/parseInt input)
      :else (map #(Integer/parseInt %) (str/split input #" ")))))


(defn initialize-state! []
  (let [numberOfCells (parse-stdin! "numberOfCells")]
    (dotimes [i numberOfCells]
      (parse-stdin! "tree"))))

(defn run [& args]
  (initialize-state!)
  (while true
    (let [; the game lasts 24 days: 0-23
          day (parse-stdin! "day")
            ; the base score you gain from the next COMPLETE action
          nutrients (parse-stdin! "nutrients")
            ; sun: your sun points
            ; score: your current score
          [sun score] (parse-stdin! "sun score")
            ; oppSun: opponent's sun points
            ; oppScore: opponent's score
            ; oppIsWaiting: whether your opponent is asleep until the next day
          [oppSun oppScore oppIsWaiting] (str/split (read-line) #" ")
          oppSun (Integer/parseInt oppSun)
          oppScore (Integer/parseInt oppScore)
          oppIsWaiting (not= "0" oppIsWaiting)
            ; the current amount of trees
          numberOfTrees (parse-stdin! "numberOfTrees")]
      (dotimes [i numberOfTrees]
        (let [; cellIndex: location of this tree
                ; size: size of this tree: 0-3
                ; isMine: 1 if this is your tree
                ; isDormant: 1 if this tree is dormant
              [cellIndex size isMine isDormant] (str/split (read-line) #" ")
              cellIndex (Integer/parseInt cellIndex)
              size (Integer/parseInt size)
              isMine (not= "0" isMine)
              isDormant (not= "0" isDormant)]))
      (let [; all legal actions
            numberOfPossibleActions (parse-stdin! "numberOfPossibleActions")]
        (dotimes [i numberOfPossibleActions]
          (let [; try printing something from here to start with
                possibleAction (read-line)]))
          ; GROW cellIdx | SEED sourceIdx targetIdx | COMPLETE cellIdx | WAIT <message>
        (output "WAIT")))))
