(ns neovim-client.message)

;; TODO - do this right!
(defn msg-id
  "Get a unique message id."
  []
  (System/currentTimeMillis))

(defn ->request-msg
  "Construct a msgpack-rpc request message."
  [type args]
  [0 (msg-id) type args])

(def id second)

;; TODO - find better way to get [B type.
(def byte-array-type (type (.getBytes "foo")))

(defn value*
    [t]

    (condp = (type t)

      byte-array-type
      (String. t)

      t))

(def value (comp value* last))