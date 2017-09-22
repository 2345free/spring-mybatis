package com.example.simples.sm.canal;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry.Entry;
import com.alibaba.otter.canal.protocol.CanalEntry.EntryType;
import com.alibaba.otter.canal.protocol.CanalEntry.EventType;
import com.alibaba.otter.canal.protocol.CanalEntry.RowChange;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * 单机模式
 *
 * @author tianyi
 * @version 1.0.4
 */
@NoArgsConstructor
public class GeneralCanalClient extends AbstractCanalClient {

    @Value("${canal.server}")
    private String server;

    private String destination = "example";

    public GeneralCanalClient(String destination) {
        super(destination);
        this.destination = destination;
    }

    public void init() {
        // 根据ip，直接创建链接，无HA的功能
        String[] host = server.split(":");
        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress(host[0] /*AddressUtils.getHostIp()*/,
                Integer.parseInt(host[1])), destination, "", "");

        final GeneralCanalClient client = this;
        client.setConnector(connector);
        client.start();
        System.err.println("Canal Client running...");

        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                try {
                    logger.info("## stop the canal client");
                    client.stop();
                } catch (Throwable e) {
                    logger.warn("##something goes wrong when stopping canal:\n{}", ExceptionUtils.getFullStackTrace(e));
                } finally {
                    logger.info("## canal client is down.");
                }
            }

        });
    }

    @Override
    protected void canalTask(List<Entry> entrys) {
        for (Entry entry : entrys) {

            if (entry.getEntryType() == EntryType.ROWDATA) {
                RowChange rowChage = null;
                try {
                    rowChage = RowChange.parseFrom(entry.getStoreValue());
                } catch (Exception e) {
                    throw new RuntimeException("parse event has an error , data:" + entry.toString(), e);
                }

                EventType eventType = rowChage.getEventType();

                if (eventType == EventType.QUERY || rowChage.getIsDdl()) {
                    continue;
                }

                String tableName = entry.getHeader().getTableName();

                if ("t_user".equalsIgnoreCase(tableName)) {

                    // 业务代码


                    /**
                     for (RowData rowData : rowChage.getRowDatasList()) {
                     if (eventType == EventType.DELETE) {
                     // 删除内存中map中的销售平台信息
                     //            				Iterator<String> iterator = OrderConstants.storeMap.keySet().iterator();
                     //            				while (iterator.hasNext()) {
                     //            				    String key = (String) iterator.next();
                     //            				    if ("1".equals(key) || "2".equals(key)) {
                     //            				       iterator.remove();
                     //            				       OrderConstants.storeMap.remove(key);
                     //            				     }
                     //            				 }

                     logger.info("删除tb_ms_store表记录");
                     printColumn(rowData.getBeforeColumnsList());
                     } else if (eventType == EventType.INSERT) {
                     // 增加内存中map中的销售平台信息
                     //                			TbMsStoreVO tbMsStoreVO=new TbMsStoreVO();
                     //                			OrderConstants.storeMap.put("", tbMsStoreVO);

                     logger.info("增加tb_ms_store表记录");
                     printColumn(rowData.getAfterColumnsList());
                     } else {
                     // 更新内存中map中的销售平台信息
                     //                			TbMsStoreVO tbMsStoreVO=new TbMsStoreVO();
                     //                			OrderConstants.storeMap.put("", tbMsStoreVO);

                     logger.info("更新tb_ms_store表记录");
                     printColumn(rowData.getAfterColumnsList());
                     }
                     }
                     */
                }

            }
        }
    }

}
