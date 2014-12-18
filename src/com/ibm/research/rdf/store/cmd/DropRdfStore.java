package com.ibm.research.rdf.store.cmd;

import java.sql.Connection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibm.research.rdf.store.Context;
import com.ibm.research.rdf.store.StoreManager;
import com.ibm.research.rdf.store.jena.RdfStoreException;

public class DropRdfStore extends AbstractRdfCommand
   {

   private static final Log log = LogFactory.getLog(DropRdfStore.class);

   public static void main(String[] args)
      {
      AbstractRdfCommand cmd = new DropRdfStore();
      cmd.runCmd(args, "droprdfstore", null);
      }

   @Override
   public void doWork(Connection conn)
      {
      try
         {
         StoreManager.dropRDFStore(conn, params.get("-backend"), params.get("-schema"), storeName, Context.defaultContext);
         }
      catch (RdfStoreException e)
         {
         log.error(e);
         System.out.println(e.getLocalizedMessage());
         }
      catch (Exception e)
         {
         log.error(e);
         System.out.println(e.getLocalizedMessage());
         }
      }

   }
