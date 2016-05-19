public class HashEntry {
      //define value types of key/value
      private int key;
      private int value;

      //define entry point for nash nodes
      HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
      }

      //get key
      public int getKey() {
            return key;
      }
      //get value
      public int getValue() {
            return value;
      }
}

public class HashMap {
      //define table size of hash table
      //128 is really small
      private final static int TABLE_SIZE = 128;

      //entry point of hash table
      HashEntry[] table;

      //initialize the hashmap
      //based on table size
      HashMap() {
            table = new HashEntry[TABLE_SIZE];
            for (int i = 0; i < TABLE_SIZE; i++)
                  table[i] = null;
      }

      //get function, takes in argument of key
      //hash is remainder of key/table_size
      //if the key at the index doesn't equal key
      //then move up one index
      //if key at that index is null, then return -1 or true
      //finally get the value
      public int get(int key) {
            int hash = (key % TABLE_SIZE);
            while (table[hash] != null && table[hash].getKey() != key)
                  hash = (hash + 1) % TABLE_SIZE;
            if (table[hash] == null)
                  return -1;
            else
                  return table[hash].getValue();
      }

      //put function, takes in argument of key and value
      //hash is non-biased and placement is based on remainder of key / TABLE_SIZE
      //if the index is not null and the key is not already stored there
      //then insert a new hash entry
      public void put(int key, int value) {
            int hash = (key % TABLE_SIZE);
            while (table[hash] != null && table[hash].getKey() != key)
                  hash = (hash + 1) % TABLE_SIZE;
            table[hash] = new HashEntry(key, value);
      }
}
