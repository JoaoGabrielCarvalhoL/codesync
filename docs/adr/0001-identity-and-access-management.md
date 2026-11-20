# ADR-0001: Identity and Access Management

## Status

Accepted

## Context

CodeSync uses Keycloak as its Identity Provider (IdP) for authentication and identity management.

The initial implementation introduced an administrative integration with Keycloak, including HTTP clients for managing users, roles, and groups, as well as mechanisms for obtaining administrative access tokens.

However, the application's user provisioning requirements have not yet been fully defined. It is still unclear whether users will register independently, be invited by organization administrators, or be managed through another business workflow.

Consequently, the application contains administrative capabilities and infrastructure that are not currently justified by established business requirements.

This introduces additional complexity, including credential management, administrative API integration, and consistency concerns between Keycloak and the application's database.

CodeSync requires a clear separation between identity management, authentication, and application-specific authorization without prematurely committing to a particular user provisioning strategy.

## Decision

CodeSync will adopt the following responsibilities:

### Identity and Authentication

Keycloak will remain responsible for:

- Managing user identities and authentication credentials.
- Authenticating users.
- Issuing OAuth 2.0 and OpenID Connect tokens.
- Providing the information required to validate issued tokens.

The CodeSync backend will not use the Keycloak Admin REST API as part of its current authentication architecture.

### Token Validation

The Spring Boot backend will operate as an OAuth2 Resource Server using Spring Security.

It will validate JWT access tokens issued by the configured Keycloak realm, including the token signature, issuer, expiration, and intended audience.

The backend will not manage administrative credentials or request administrative access tokens for routine authentication and authorization.

### Application-Specific Authorization

CodeSync will manage its own business authorization rules.

These rules include access to organizations, projects, tasks, and other domain resources.

Authentication through Keycloak does not automatically grant access to CodeSync resources.

Application-specific permissions will be evaluated by the backend according to the authenticated user's relationships and privileges within the domain.

### User Domain Model

CodeSync will maintain its own `User` entity for application-specific information and domain relationships.

The application will associate local users with their external identity using the identity provider's subject identifier (`sub`).

The internal user identifier will remain independent of the identity provider.

The user provisioning strategy is intentionally left undefined until the relevant business requirements are established.

### Frontend Authentication

A future browser-based frontend will use the OpenID Connect Authorization Code Flow with PKCE.

The frontend will not hold Keycloak administrative credentials.

## Alternatives Considered

### Maintain the Keycloak Administrative Integration

Continue using the Keycloak Admin REST API to create users and manage roles and groups directly from CodeSync.

**Not selected:** The current business requirements do not justify this level of administrative integration. It would introduce unnecessary coupling and additional responsibilities.

This alternative may be reconsidered if future requirements explicitly demand administrative identity operations.

### Implement Authentication Within CodeSync

Manage user credentials, authentication, and token issuance directly in the application.

**Not selected:** This would duplicate capabilities already provided by Keycloak and increase security and maintenance responsibilities.

### Use Keycloak Roles for All Business Permissions

Represent organization memberships, project permissions, and other domain-specific access rules primarily through Keycloak roles or groups.

**Not selected:** These permissions depend on CodeSync's domain relationships and are better managed alongside the corresponding business data.

## Consequences

### Positive

- Clear separation between identity management and business authorization.
- Reduced coupling with Keycloak's administrative APIs.
- Elimination of unnecessary administrative token management.
- Reduced complexity in the authentication infrastructure.
- Greater flexibility to define user provisioning workflows in the future.
- Domain authorization remains under CodeSync's control.

### Negative and Trade-offs

- CodeSync must maintain the association between external identities and local users.
- The backend must implement and test application-specific authorization rules.
- Changes to identity information may require a synchronization or update strategy.
- User provisioning and lifecycle management remain unresolved and must be addressed before implementing workflows that depend on them.

## Implementation Notes

The migration will include:

1. Identifying and removing unused Keycloak administrative clients, services, and related configurations.
2. Removing administrative credentials and service-account dependencies that are no longer required.
3. Configuring Spring Security to validate JWT access tokens.
4. Reviewing token issuer and audience validation.
5. Reviewing the Keycloak health indicator and authentication-related logging.
6. Updating the Keycloak realm configuration and application documentation.
7. Adding automated tests for authentication and authorization behavior.

These changes will be implemented incrementally and reviewed through separate pull requests where appropriate.