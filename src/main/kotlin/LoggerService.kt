class LoggerService {
    private var store: MutableMap<String, Int> = mutableMapOf()
    fun shouldPrintMessage(timestamp: Int, message: String)=
        if (store.containsKey(message)) {
            if (timestamp >= store[message]!!.plus(10)) {
                store[message] = timestamp
                true
            } else false

        } else {
            store[message]=timestamp
            true
        }
}