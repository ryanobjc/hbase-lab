package org.hbase;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class Client1 {

  public static void main(String [] args) throws IOException {
    HBaseConfiguration conf = new HBaseConfiguration();

    HTable table = new HTable(conf, "test_table");

    Put put = new Put(Bytes.toBytes("hello_row"));
    put.add(Bytes.toBytes("test"), Bytes.toBytes("qualifier"),
        Bytes.toBytes("Hello HBase World!"));
    table.put(put);

    table.close();

    System.out.println("Success!");
  }
}
