/**
 * Copyright © 2016-2017 Cloudera, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cloudera.labs.envelope.derive.dq;

import com.cloudera.labs.envelope.load.Loadable;
import com.typesafe.config.Config;
import org.apache.spark.sql.Row;

import java.io.Serializable;

public interface RowRule extends Serializable, Loadable {

  /**
   * Called once by Envelope to configure the data quality rule
   * @param name name of the rule
   * @param config configuration for the rule
   */
  void configure(String name, Config config);

  /**
   * Apply the rule to the supplied row
   * @param row the {@link Row} on which to run the check
   * @return pass or fail
   */
  boolean check(Row row);

}