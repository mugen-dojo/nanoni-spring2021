(ns bots.template
  (:require [clojure.string :as str]))

(defn output [msg] (println msg) (flush))
(defn debug [msg] (binding [*out* *err*] (println msg) (flush)))
(defn initialize-state! []
  (let [numberOfCells (Integer/parseInt (read-line))]
    ; index: 0 is the center cell, the next cells spiral outwards
    ; richness: 0 if the cell is unusable, 1-3 for usable cells
    ; neigh0: the index of the neighbouring cell for each direction
    (dotimes [i numberOfCells]
      ; ignoring the neigh values for now
      (let [
            [index richness] (map #(Integer/parseInt %) (str/split (read-line) #" "))])))
  (defn run [& args]
    (initialize-state!)
    (while true
      (let [; the game lasts 24 days: 0-23
            day (Integer/parseInt (read-line))
            ; the base score you gain from the next COMPLETE action
            nutrients (Integer/parseInt (read-line))
            ; sun: your sun points
            ; score: your current score
            [sun score] (map #(Integer/parseInt %) (str/split (read-line) #" "))
            ; oppSun: opponent's sun points
            ; oppScore: opponent's score
            ; oppIsWaiting: whether your opponent is asleep until the next day
            [oppSun oppScore oppIsWaiting] (str/split (read-line) #" ")
            oppSun (Integer/parseInt oppSun)
            oppScore (Integer/parseInt oppScore)
            oppIsWaiting (not= "0" oppIsWaiting)
            ; the current amount of trees
            numberOfTrees (Integer/parseInt (read-line))]
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
              numberOfPossibleActions (Integer/parseInt (read-line))]
          (dotimes [i numberOfPossibleActions]
            (let [; try printing something from here to start with
                  possibleAction (read-line)]))

          ; (debug "Debug messages...")

          ; GROW cellIdx | SEED sourceIdx targetIdx | COMPLETE cellIdx | WAIT <message>
          (output "WAIT"))))))
