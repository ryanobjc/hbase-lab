package org.hbase;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class Client2 {
  public static void main(String [] args) throws IOException {
    HBaseConfiguration conf = new HBaseConfiguration();
    HTable table = new HTable(conf, "test_table");

    Get get = new Get(Bytes.toBytes("hello_row"));
    Result result = table.get(get);

    byte [] value = result.getValue(Bytes.toBytes("test"),
        Bytes.toBytes("qualifier"));
    System.out.println(Bytes.toString(value));
  }
}
