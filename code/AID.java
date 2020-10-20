class AID {

  // gets an agent's local name
  String getLocalName()
  
  // gets the hosting environment's name (which may be null)
  String getEnvironmentName()
  
  // true is the environment name is missing
  boolean isLocal()
  
  // creates a full AID out of a local and environment name
  static AID full(String local, String environment)

  // creates a local AID out of a local agent name
  static AID local(String local)

  // parses strings in the form "agent@environment" as full AIDs
  // parses strings in the form "name" as local AIDss
  static AID parse(String input)
}

