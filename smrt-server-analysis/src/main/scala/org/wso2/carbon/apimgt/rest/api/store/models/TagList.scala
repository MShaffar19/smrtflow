/**
 * NOTE: This class is auto generated by the akka-scala (beta) swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen
 * For any issue or feedback, please open a ticket via https://github.com/swagger-api/swagger-codegen/issues/new
 */

package org.wso2.carbon.apimgt.rest.api.store.models

import org.joda.time.DateTime


case class TagList (
  /* Number of Tags returned.  */
  count: Option[Int],
  /* Link to the next subset of resources qualified. Empty if no more resources are to be returned.  */
  next: Option[String],
  /* Link to the previous subset of resources qualified. Empty if current subset is the first subset returned.  */
  previous: Option[String],
  list: Option[Seq[Tag]])


