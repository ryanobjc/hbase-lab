package org.hbase;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.NavigableMap;

public class Client3 {
  public static void main(String [] args) throws IOException {
    HBaseConfiguration conf = new HBaseConfiguration();
    HTable table = new HTable(conf, "test_table");

    Scan scan = new Scan();
    ResultScanner scanner = table.getScanner(scan);
    Result result;
    while ( (result = scanner.next()) != null) {
      NavigableMap<byte[], NavigableMap<byte[],byte[]>> data = result.getNoVersionMap();
      for ( byte [] family : data.keySet() ) {
        NavigableMap<byte[],byte[]> familyInfo = data.get(family);
        for ( byte [] qualifier : familyInfo.keySet() ) {
          byte [] value = familyInfo.get(qualifier);
          System.out.println(Bytes.toString(family) +
          ":" + Bytes.toString(qualifier)
          + " = " + Bytes.toString(value));
        }
      }
    }
  }
}
